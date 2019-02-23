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
            
                    stage ('Checkout') {
                        steps {
                            checkout([$class: 'GitSCM', branches: [[name: '*/DPLExample']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/devops81/DevOps-Demo.git']]])
                            
                        }
                    }
                    
                    stage ('Build the project') {
                        steps {
                            dir("/var/lib/jenkins/workspace/Pipeline-Slack-Example/examples/feed-combiner-java8-webapp") {
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
											sh 'cp  -rf  /var/lib/jenkins/workspace/Pipeline-Slack-Example/examples/feed-combiner-java8-webapp/target/devops.war /home/jarfile'
                            
											}
                                  
													}
				   stage ('Sending Slack notification')
				   {
						steps {
						slackSend baseUrl: 'https://hooks.slack.com/services/', 
						channel: 'jbuildnotification', 
						color: 'good', 
						message: "started ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)", teamDomain: 'devops81', 
						tokenCredentialId: 'JBN'
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
                    
			stage('Branch check') {
				 if (env.BRANCH_NAME == "master") 
				{                                          
				echo "You are in master"
    				} 
				
				else 
				{                                   
        				echo "You are not in master"
    				}    
                  
                 }
		    post {
 always {
   sh 'echo "This will always run"'
 }
 success {
  sh 'echo "This will run only if successful"'
 }
 failure {
  sh 'echo "This will run only if failed"'
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
                    
               
			
			
			
            
                   
                    
                        
            
