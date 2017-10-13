#!/usr/bin/env bash


pwd

ls -la

openssl aes-256-cbc -K $EKEY -iv $EIV -in deploy/$DEPLOY_KEY -out deploy/deploy_key -d

ssh-add deploy/deploy_key

cd $TRAVIS_BUILD_DIR/..


rm -rf gh-pages

git clone -b gh-pages git@github.com:$TRAVIS_REPO_SLUG gh-pages

cd gh-pages

pwd

ls -la

mkdir -p downloads/eclipse/repository/

rm -rf downloads/eclipse/repository/*

mv ../mde_optimiser/src/releng/uk.ac.kcl.mdeoptimise.repository/target/* downloads/eclipse/repository/

git add --all

git config user.name "Travis CI"
git config user.email "alex+git-CIBUILD@onboot.org"

git commit -m "Published build id: $TRAVIS_BUILD_NUMBER"

git push origin gh-pages

echo "Done"
