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
    
     
    stage 'compile'
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
}