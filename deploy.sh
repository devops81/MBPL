#!/bin/bash
# deploy.sh - master script to provision an EC2 instance and
# deploy a test application to it using AWS CloudFormation and CodeDeploy
# Configure AWS credentials
# Cleanup any resources left from previous runs (prevents error msgs.)

./configure-aws.sh

./cleanup.sh
# Create a zip archive for myApp with no encompassing directory
echo "Creating zip archive for test app"

sudo zip -qr ./test.zip *

# Upload the archive to S3
sudo aws s3 cp test.zip s3://deploy-app-storage

# Run CodeDeploy to create a CodeDeploy Application for myApp
echo "Starting CodeDeploy operations"
sudo aws deploy create-application --application-name BankScoreCard-Test-Deploy
# Run CodeDeploy to create a CodeDeploy DeploymentGroup for the instances
sudo aws deploy create-deployment-group --application-name BankScoreCard-Test-Deploy --deployment-group-name BankScoreCard-Test-Deploy --ec2-tag-filters Key=Name,Value=Code-Deploy,Type=KEY_AND_VALUE --service-role-arn arn:aws:iam::262625230303:role/Aws-CodeDeploy
# Run CodeDeploy to create a CodeDeploy Deployment for this revision of myApp
sudo aws deploy create-deployment --application-name BankScoreCard-Test-Deploy --deployment-config-name CodeDeployDefault.OneAtATime --deployment-group-name BankScoreCard-Test-Deploy --description "BankScoreCard-Test-Deploy deployment" --s3-location bucket=deploy-app-storage,bundleType=zip,key=test.zip
echo "Deployment complete."


