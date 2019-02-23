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
                    
                  
                 }
				}
                    
               
			
			
			
            
                   
                    
                        
            
