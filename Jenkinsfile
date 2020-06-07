// TODO: Read Example http://engineering.teacherspayteachers.com/2017/05/16/unifying-deployments-for-microservices-via-jenkins.html
// TODO: Read https://wilsonmar.github.io/jenkins2-pipeline/
// TODO: Reference, https://github.com/jfrog/project-examples/tree/master/jenkins-examples/pipeline-examples/declarative-examples


def springBootMvnBuild(directory){
	node{
		dir(directory) {
	            sh 'mvn clean install'
	    }
    }
}
   


stage 'checkout'

node{
    
   checkout([
	   		$class: 'GitSCM',
	   		branches: [[name: '**']],
	   		doGenerateSubmoduleConfigurations: false,
	   		submoduleCfg: [],
	   		userRemoteConfigs: [
	   			[credentialsId: 'gitlab-3', name: 'origin', url: 'https://gitlab.worscipe.com/Mbd06b/bright.git'],
	   			[credentialsId: 'mbd06b@gmail.com priv key', name: 'github', url: 'git@github.com:Mbd06b/bright.git']
	   		],
	   		extensions: [
				[ $class: 'PreBuildMerge',
		            options: [
		                fastForwardMode: 'FF',
		                mergeRemote: 'github',
		                mergeTarget: 'development'
		            ]
		        ]
	        ]
        ])
} 
    
//   
stage 'compile'

		bootPipeline('parent')
		
        dir('parent') {
            // some block
            sh 'mvn compile'
        }
        
        
        dir('common') {
            sh 'mvn clean install deploy'
        }
        
        
        dir('config-service') {
            sh 'mvn clean install'
        }
        
        dir('discovery-service') {
            sh 'mvn compile'
        }
        
        dir('gateway-service') {
            sh 'mvn compile'
        }
        
        dir('users') {
            sh 'mvn compile'
        }
        
        dir('ideas') {
        // some block
           sh 'mvn compile'
        }
    
        
            
        stage ( 'install' ) {
                     
         //  dir('config-service') {
         //       sh 'mvn clean install'
         //   }       
             
             dir ( 'parent') {
    	          withMaven (){ // () uses global Jenkins defaults
    	            sh "mvn clean install"   
    	          }    
             }
             
        }

    
    
        stage ('image'){
             dir ('config-service') {
               //withDockerRegistry(credentialsId: 'nexus-admin', url: 'http://save.worscipe.com:8080') {}
                 docker.withRegistry('https://save.worscipe.com:8080', 'nexus-admin') {
                   def app = docker.build "bright/config-service"
                   app.push()                
                 }
             }
        }
        
        stage ('deploy'){
        	// TODO https://github.com/jenkinsci/kubernetes-cd-plugin
        	kubernetesDeploy(kubeconfigId: 'kubeconfig-credentials-id',               // REQUIRED

                 configs: '<ant-glob-pattern-for-resource-config-paths>', // REQUIRED
                 enableConfigSubstitution: false,

                 secretNamespace: '<secret-namespace>',
                 secretName: '<secret-name>',
                 dockerCredentials: [
                        [credentialsId: '<credentials-id-for-docker-hub>'],
                        [credentialsId: '<credentials-id-for-other-private-registry>', url: '<registry-url>'],
                 ]
			){ 
			echo "kubernetesDeploy" 
			}
		}

            
          

}