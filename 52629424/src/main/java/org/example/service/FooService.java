package org.example.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class FooService
{
  @Transactional
  public void foo()
  {
    System.out.println("transName: "
                           + TransactionSynchronizationManager.getCurrentTransactionName()
                           + ", isAlive: "
                           + TransactionSynchronizationManager.isActualTransactionActive());
  }
}
