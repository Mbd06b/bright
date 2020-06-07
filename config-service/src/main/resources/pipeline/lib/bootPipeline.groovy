/**
 * *  Ref: https://jenkins.io/blog/2017/10/02/pipeline-templates-with-shared-libraries/
*  A shared pipeline for building spring-boot services
*
*  @param directory , the directory containing the spring-boot service (ex: "config-service")
*  
*  @param imageName, the the name of the docker image (ex: "bright/config-service")
*  
*  Jenkinsfile usage:
*  
*   bootPipeline('config-service', 'bright/config-service')
*
 */
def call(def directory, def imageName) {
	agent any
	
		stages {		
			dir (directory) {
				
			   stage ( 'compile' ) {
					withMaven (){ // () uses global Jenkins defaults
					  sh "mvn clean compile"
					}
			   }
			   
				stage('build') {
					steps {
						sh 'mvn clean package -DskipTests=true'
					}
				}
				
		
		//		stage ('test') {
		//			steps {
		//				parallel (
		//					"unit tests": { sh 'mvn test' },
		//					"integration tests": { sh 'mvn integration-test' }
		//				)
		//			}
		//		}
				
				stage('depoly artifact'){
					sh 'mvn deploy'
				}
				
		
				stage ('image to registry'){
				
				  //withDockerRegistry(credentialsId: 'nexus-admin', url: 'http://save.worscipe.com:8080') {}
					docker.withRegistry('https://save.worscipe.com:8080', 'nexus-admin') {
					  def app = docker.build imageName //ex: "bright/config-service" 
					  app.push()
					}
				}
				
			}//dir
			
		}//stages
}