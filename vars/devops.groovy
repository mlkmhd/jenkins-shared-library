def verifyK8sManifests() {

    sh """
        set -xe;
        cd /tmp; 
        curl -Lk https://github.com/stackrox/kube-linter/releases/download/v0.6.5/kube-linter-linux.tar.gz -O; 
        tar -xvzf kube-linter-linux.tar.gz;
        
        cd -;
        for manifest_file in \$(find . -name '*.yaml'); do
            /tmp/kube-linter lint \${manifest_file}
        done

        echo 'verified'
    """
}
