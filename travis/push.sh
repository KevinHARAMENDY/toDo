#!/bin/sh

git remote add cleverapps
https://$CLEVER_TOKEN:$CLEVER_SECRET@push.clever-cloud.com/app_7e280e9c-f637-4303-8fab-6e7003e938af.git
git --verbose --force push cleverapps master