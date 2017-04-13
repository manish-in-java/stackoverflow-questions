package org.example;

import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement(proxyTargetClass = true)
public class ProxiedClassConfiguration extends ApplicationConfiguration
{
}
