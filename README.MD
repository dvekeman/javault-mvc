# Javault MVC example web application

## Setup tomcat

Edit the catalina.policy ```/opt/tomcat8/conf/catalina.policy```

At the very end add:

    grant codeBase "file:${catalina.home}/webapps/javault-mvc-0.0.1/-" {
        permission java.security.AllPermission;
    };

See doc/catalina.policy.example

## Deploying the war

Build the war file

    ./gradlew clean war

Copy the war file from build/libs/javault-mvc-0.0.1.war to the tomcat webapps directory

    rm -rf /opt/tomcat8/webapps/javault-mvc-0.0.1*
    cp build/libs/javault-mvc-0.0.1.war /opt/tomcat8/webapps/

Start tomcat with security enabled:

    /opt/tomcat8/bin/startup.sh -security

**or** to test what happens when security is disabled:

    /opt/tomcat8/bin/startup.sh

## Test the application

Navigate to ```http://127.0.0.1:8080/javault-mvc-0.0.1/```

Form:

![Sample form](https://github.com/dvekeman/javault-mvc/blob/master/doc/img/form.png "Sample form")

When running without ```-security```

![Without security](https://github.com/dvekeman/javault-mvc/blob/master/doc/img/1_without_security.png "Without security")

When running with ```-security```

![With security](https://github.com/dvekeman/javault-mvc/blob/master/doc/img/2_with_security.png "With security")
