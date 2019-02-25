            pipeline {
                agent {
                    label "master"
                }
                tools {
                    maven 'Maven3'
            
                }
                stages {
                    stage ('Initialize') {
                        steps {
                            sh '''
                                echo "PATH = $PATH"
                                echo "M2_HOME = $M2_HOME"
                            '''
                        }
                    }
					
					stage ('Initialize2') {
                        steps {
                            sh '''
                                echo "PATH = $PATH"
                                echo "M2_HOME = $M2_HOME"
                            '''
                        }
                    }
            
                    stage ('Checkout') {
                        steps {
                            checkout([$class: 'GitSCM', branches: [[name: '*/22519']], 
				      doGenerateSubmoduleConfigurations: false, extensions: [], 
				      submoduleCfg: [], 
				      userRemoteConfigs: [[url: 'https://github.com/devops81/MBPL.git']]])
                            
                        }
                    }
                    
                    stage ('Build the project') {
                        steps {
                            dir("/var/lib/jenkins/workspaces/SLACKINTEGRATION/examples/feed-combiner-java8-webapp") {
                         sh 'mvn clean install'
                            }
                            
                        }
                    }
                      stage ('Generate JUNIT REPORT') {
                         steps {
                              parallel ( 
                                  'Archeiving the reports': 
                        {
                            junit 'examples/feed-combiner-java8-webapp/target/surefire-reports/*.xml'
                            
                        },
                                  'Sending out the JUNIT report' :
                                  {                  
                                     emailext body: 'Junits reporting getting archived', subject: 'junit update', to: 'devops81@gmail.com'
                                 },
                                          
                                           'calling Job one' :
                                  {                  
                                    build 'BR_devam/job-1' 
                                 },
                                           'Calling job two' :
                                  {                  
                                         build 'BR_devam/job-02'  
                                 }
                                 )
                        } 
                    }
                    stage ('Deploy the application') {
                     
                                      steps {          
							sh 'cp  -rf  /var/lib/jenkins/workspace/SLACKINTEGRATION/examples/feed-combiner-java8-webapp/target/devops.war /home/jarfile'
                            
											}
                                  
													}
				 
			
			
						  
             
                    
                    stage ('Send out email Notification') {
                        agent {
                            label "master"
                        }
                        steps {
                     	
                         emailext body: '${SCRIPT,template="email.groovy.template"}', mimeType: 'text/html', subject: '$Defualt_Subject', to: 'devops81@gmail.com'
                            
                        }
                    }
					
			 stage ('Branch check') {
				 
                        steps {
                          echo "You are in master branch ${env.BRANCH_NAME}"  
                               }
                                                 }	
                    
			
				 }
				 
		    post {
 always {
   sh 'echo "This will always run"'
 }
 success {
  slackSend baseUrl: 'https://hooks.slack.com/services/', 
	  channel: 'jenkinsjobalert', color: 'green', 
	  message: "started ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)", 
	  teamDomain: 'devops81', 
	  tokenCredentialId: '22519'
 }
 failure {
 slackSend baseUrl: 'https://hooks.slack.com/services/', 
	  channel: 'jenkinsjobalert', color: 'danger', 
	  message: "Build FAILED ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)", 
	  teamDomain: 'devops81', 
	  tokenCredentialId: '22519'
 }
 unstable {
  sh 'echo "This will run only if the run was marked as unstable"'
 }
 changed {
  sh 'echo "This will run only if the state of the Pipeline has changed"'
  sh 'echo "For example, the Pipeline was previously failing but is now successful"'
  sh 'echo "... or the other way around :)"'
 }
}
				
				
}
                    
               
			
			
			
            
                   
                    
                        
            
