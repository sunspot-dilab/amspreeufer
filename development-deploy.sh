#!/usr/bin/env bash
set -e;

./gradlew clean assembly --info;

cf login -a https://api.sys.cloud.vw-dilab.com -u "$CF_USER" -p "$CF_PASSWORD" -o DilabLibrary -s development
cf push -f manifest.yml -n lib
