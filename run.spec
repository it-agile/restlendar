#!/bin/sh

SERVER=server/

check_exit_value() {
    exit_value=$?
    if [ "$exit_value" -ne "0" ] ; then
        exit $exit_value
    fi
}

gradle --project-dir "server"
check_exit_value

play start "$SERVER"
check_exit_value

gradle --project-dir "spec"

play stop "$SERVER"

