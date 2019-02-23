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
                            dir("/var/lib/jenkins/workspace/Pipeline-Slack/examples/feed-combiner-java8-webapp") {
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
                                    build 'Job-One' 
                                 },
                                           'Calling job two' :
                                  {                  
                                         build 'Job-Two'  
                                 }
                                 )
                        } 
                    }
                    stage ('Deploy the application') {
                     
                                      steps {
                              parallel ( 
                                  'Deploy the application': 
                        {
                             sh 'cp  -rf  /var/lib/jenkins/workspace/Pipeline-Slack/examples/feed-combiner-java8-webapp/target/devops.war /home/jarfile'
                            
                        },
                                  'Send Slack notification' :
                                  {                  
                                     slackSend channel: 'jbuildnotification', message: 'good', teamDomain: 'devops81', tokenCredentialId: 'JBN'
                                 }
                                 )
                        }
						  }
             
                    
                    stage ('Send out email Notification') {
                        agent {
                            label "master"
                        }
                        steps {
                            emailext body: '$DEFAULT_CONTENT', subject: '$DEFAULT_SUBJECT', to: 'devops81@gmail.com'
            
                            
                        }
                    }
                    
                  
                }
                    
               }
			
			
			}
            
                   
                    
                        
            
