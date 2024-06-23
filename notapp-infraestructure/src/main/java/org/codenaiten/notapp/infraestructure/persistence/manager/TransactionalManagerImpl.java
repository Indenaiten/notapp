package org.codenaiten.notapp.infraestructure.persistence.manager;

import org.codenaiten.notapp.domain.port.persistence.manager.TransactionalManagerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


@Component
public class TransactionalManagerImpl implements TransactionalManagerPort {

    private final PlatformTransactionManager transactionManager;
    private TransactionStatus status;



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| CONSTRUCTOR |------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Autowired
    public TransactionalManagerImpl( final PlatformTransactionManager transactionManager ) {
        this.transactionManager = transactionManager;
    }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| IMPLEMENT METHODS |------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @Override
    public <T> TransactionResult<T> run( final TransactionSupplier<T> transaction ) {
        TransactionResult<T> result = TransactionResult.of( null );
        try{
            this.init();
            result = TransactionResult.of( transaction.get() );
            this.commit();
        }
        catch ( final RuntimeException re ){
            this.rollback();
            throw re;
        }
        catch ( final Exception e ){
            this.rollback();
            result.setException( e );
        }

        return result;
    }

    @Override
    public TransactionResult<Void> run( final TransactionRunnable transaction ) {
        return run( () -> {
            transaction.run();
            return null;
        });
    }

    @Override
    public void init() {
        this.status = this.transactionManager.getTransaction( new DefaultTransactionDefinition());
    }

    @Override
    public void commit() {
        if ( this.status != null) {
            this.transactionManager.commit( this.status );
        }
    }

    @Override
    public void rollback() {
        if ( this.status != null) {
            this.transactionManager.rollback( this.status );
        }
    }

// ------------------------------------------------------------------------------------------------------------------ \\

}
