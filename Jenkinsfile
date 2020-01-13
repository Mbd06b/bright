node{
    
   checkout scm
    
    stage('sync'){
        
    // list all env variables available in pipeline
    echo ":::List all env globals:::"
    echo sh(script: 'env|sort', returnStdout: true)
    
    echo ":::scm.getUserRemoteConfigs()[0].getUrl(); :::" 
    echo scm.getUserRemoteConfigs()[0].getUrl();
    
    echo ":::scm.getUserRemoteConfigs(); :::" 
    echo scm.getUserRemoteConfigs();
    
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