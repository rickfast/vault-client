[![Build Status](https://travis-ci.org/rickfast/vault-client.svg)](https://travis-ci.org/rickfast/vault-client)
[ ![Download](https://api.bintray.com/packages/orbitz/vault-client/vault-client/images/download.svg) ](https://bintray.com/orbitz/vault-client/vault-client/_latestVersion)

# Vault Client for Java

Work in progress

## Examples

```java
import static com.orbitz.vault.Vault.Builder.builder;

Vault vault = builder().host("localhost").build();
UserPassClient userPass = vault.userPass();

String token = userPass.login("rickfast", "mypassword");

SecretClient secretClient = vault.secret(token);

System.out.println(secretClient.getSecret("foo"));
```
