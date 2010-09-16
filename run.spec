#!/bin/sh

SERVER=server/

play start "$SERVER"
exit_value=$?
if [ "$exit_value" -ne "0" ] ; then
    exit $exit_value
fi
gradle --project-dir "spec"
play stop "$SERVER"

