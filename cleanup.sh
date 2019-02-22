#!/bin/bash
# cleanup.sh - cleanup the CodeDeploy application
#   application after a successful or failed test.
#   Cleanup removes all CodeDeploy resources
echo "Starting cleanup of old resources"

# Clean up any previous CodeDeploy artifacts 
aws deploy delete-application --application-name BankScoreCard-Test-Deploy
echo "Sleeping 3 minutes to allow time for cleanup to complete"
sleep 180
echo "End of cleanup script"

