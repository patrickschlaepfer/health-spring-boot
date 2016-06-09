# Health Spring Systemone Route

Contains the route for system one

To access via howtio use as Host: localhost, Port 9000 and Path jolokia

User and password is admin/admin

## Adapters

| Protocol   | Port |
|---|---|
| MLLP/HL7 | 8887 |
| Webservice |  


## Deploy to wildfly

Link to the plugin: https://docs.jboss.org/wildfly/plugins/maven/latest/


### Deploy

```
mvn wildfly:deploy
```

### Redeploy

```
mvn wildfly:redeploy
```


## Configure Wildfly

You have to add the following lines to C:\Apps\wildfly-10.0.0.Final\modules\system\layers\base\sun\jdk\main\module.xml

```
    <path name="com/sun/org/apache/xerces/internal/dom"/>
    <path name="com/sun/org/apache/xerces/internal/xni"/>
    <path name="com/sun/org/apache/xerces/internal/jaxp"/>
```

