# Vault Client for Java

Work in progress

## Examples

```java
import static com.orbitz.vault.Vault.Builder.builder;

Vault vault = builder().host("localhost").build();
UserPassClient userPass = vault.userPass();

String token = userPass.login("rickfast", "mypassword");

vault.setToken(token);

SecretClient secretClient = vault.secret();

System.out.println(secretClient.getSecret("foo"));
```
