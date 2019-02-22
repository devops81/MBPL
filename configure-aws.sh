#!/bin/bash

echo -e "Automatically configuring AWS credentials : \n";
aws configure <<EOF
AKIAI6FYM6WPTG3NYWQA
GtcdEeb2MYSKKSlBdSxnKnlKuDwAoFDy03E4Xtgl
us-east-1
json
EOF
echo -e "/n";
echo -e "Configuration completed.. \n";
