node{
    
   checkout scm
    
    stage ('compile') {
    
    //TODO move parent to some global jenkins library
        dir('parent') {
            // some block
            sh 'mvn compile'
        }
        
        dir('config-service') {
            sh 'mvn clean install'
        }
        
    }
    
         stage ('image'){
             dir ('config-service') {
                 docker.withRegistry('https://save.worscipe.com:8080', 'nexus-admin') {
                   def app = docker.build "bright/config-service"
                   app.push()                
                 }
             }
        }
    
}