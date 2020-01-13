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
    
    stage('sync'){
    
    // syncs the PreBuildMerge that occured in scm checkout step with the remote repository
  //  sh "git checkout development"
  //  sh "git pull" 
    //something unique
  //  withCredentials([sshUserPrivateKey(credentialsId: 'mbd06b@gmail.com priv key')]) {
  // sh("git push github development:development")
  //	}
	
//   withCredentials([usernamePassword(credentialsId: 'mbd06b@gmail.com priv key', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD')]) {
//    sh("git tag -a some_tag -m 'Jenkins'")
//    sh('git push git://${GIT_USERNAME}:${GIT_PASSWORD}@github.com:Mbd06b/bright.git')
//  }
  
      sshagent(['mbd06b@gmail.com priv key']) {
        sh('''
            #!/usr/bin/env bash
            set +x
            # If no host key verification is needed, use the option `-oStrictHostKeyChecking=no`
            export GIT_SSH_COMMAND="ssh -oStrictHostKeyChecking=no"
            
            git checkout development
            git pull
            git push github development:development
        ''')
    }
    
    // list all env variables available in pipeline
    echo ":::List all env globals:::"
    echo sh(script: 'env|sort', returnStdout: true)
    
    echo ":::scm.getUserRemoteConfigs()[0].getUrl(); :::" 
    echo scm.getUserRemoteConfigs()[0].getUrl();
    
    echo ":::scm.getUserRemoteConfigs();:::" 
    echo scm.getUserRemoteConfigs().toString();
    
    echo "::: git remote -v :::" 
    sh "git remote -v" 
     
    }
    
    stage 'compile'
        dir('parent') {
            // some block
            sh 'mvn compile'
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