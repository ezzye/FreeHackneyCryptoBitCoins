#!/usr/bin/env bash

BASE_DIR="$( dirname "$0" )"

# 2>&1 because that makes life much easier in under-test.rb
exec 2>&1

jar="$( echo "$BASE_DIR"/target/naitiveClient.jar )"
exec java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -jar "$jar" "$@"

