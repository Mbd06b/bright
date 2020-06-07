/**
*  Ref: https://jenkins.io/blog/2017/10/02/pipeline-templates-with-shared-libraries/
*  A shared pipeline for building spring-boot services
*
*  @param pipelineParams
*
*    pipelineParams {
*        branch = 'master'
*        scmUrl = 'ssh://git@myScmServer.com/repos/myRepo.git'
*        serverPort = '8080'
*        developmentServer = 'dev-myproject.mycompany.com'
*        stagingServer = 'staging-myproject.mycompany.com'
*        productionServer = 'production-myproject.mycompany.com'
*    }
*/
def call(Map pipelineParams) {

	pipeline {
		agent any
		stages {
			stage('checkout git') {
				steps {
					git branch: pipelineParams.branch, credentialsId: 'GitCredentials', url: pipelineParams.scmUrl
				}
			}

			stage('build') {
				steps {
					sh 'mvn clean package -DskipTests=true'
				}
			}

			stage ('test') {
				steps {
					parallel (
						"unit tests": { sh 'mvn test' },
						"integration tests": { sh 'mvn integration-test' }
					)
				}
			}

			stage('deploy developmentServer'){
				steps {
					deploy(pipelineParams.developmentServer, pipelineParams.serverPort)
				}
			}

			stage('deploy staging'){
				steps {
					deploy(pipelineParams.stagingServer, pipelineParams.serverPort)
				}
			}

			stage('deploy production'){
				steps {
					deploy(pipelineParams.productionServer, pipelineParams.serverPort)
				}
			}
		}
		post {
			failure {
				mail to: pipelineParams.email, subject: 'Pipeline failed', body: "${env.BUILD_URL}"
			}
		}
	}
}