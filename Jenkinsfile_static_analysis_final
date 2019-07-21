node {
git "https://github.com/TonyYuta/" + repo + ".git"
def mvnHome = tool 'Maven_3.5.0'

// next line works fine with findbugs but not with cpd
sh "'${mvnHome}/bin/mvn' clean site -Dbrowser=${browser} -Dgroups=${groups}"

//next line doesn't work with findbugs & cpd
//stage('Maven')  {sh "'${mvnHome}/bin/mvn' clean findbugs:findbugs pmd:pmd pmd:cpd checkstyle:checkstyle test -Dmaven.test.failure.ignore=true -Dgroups=all -Dbrowser=chrome"}

stage('Test')			{step([$class:	'Publisher', 			testResults: 	'**/testng-results.xml'													 ])}
stage('PMD')			{step([$class:	'PmdPublisher', 		pattern: 		'**/pmd*.xml',				failureThreshold: 50, 	unstableThreshold: 20])}
stage('CheckStyle') 	{step([$class: 	'CheckStylePublisher',	pattern: 		'**/checkstyle*.xml',		failureThreshold: 100,	unstableThreshold: 50])}
stage('FindBugs') 		{step([$class:	'FindBugsPublisher', 	pattern: 		'**/findbugs*.xml',			failureThreshold: 30,	unstableThreshold: 10])}
stage('CPD')			{step([$class:	'DryPublisher', 		pattern: 		'**/cpd*.xml',				failureThreshold: 2,	unstableThreshold: 1 ])}
stage('Code Coverage')	{step([$class:	'JacocoPublisher', 		execPattern:	'**/**.exec', classPattern:'**/classes', sourcePattern:'**/src/main/java'])}
}
