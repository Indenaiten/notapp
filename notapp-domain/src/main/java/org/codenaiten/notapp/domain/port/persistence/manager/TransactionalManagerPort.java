package org.codenaiten.notapp.domain.port.persistence.manager;

public interface TransactionalManagerPort {

    <T> TransactionResult<T> run( TransactionSupplier<T> transaction );

    TransactionResult<Void> run( TransactionRunnable transaction );

    void init();

    void commit();

    void rollback();



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| INPUT |------------------------------------------------------------------------------------------------------ \\
// ------------------------------------------------------------------------------------------------------------------ \\

    @FunctionalInterface
    interface TransactionSupplier<T> { T get() throws Exception; }

    @FunctionalInterface
    interface TransactionRunnable { void run() throws Exception; }



// ------------------------------------------------------------------------------------------------------------------ \\
// ---| OUTPUT |----------------------------------------------------------------------------------------------------- \\
// ------------------------------------------------------------------------------------------------------------------ \\

    class TransactionResult<T> {

        private final T result;
        private Exception exception;



    // -------------------------------------------------------------------------------------------------------------- \\
    // ---| CONSTRUCTOR |-------------------------------------------------------------------------------------------- \\
    // -------------------------------------------------------------------------------------------------------------- \\

        private TransactionResult( final T result ) {
            this.result = result;
            this.exception = null;
        }

    // -------------------------------------------------------------------------------------------------------------- \\
    // ---| BUILDER |------------------------------------------------------------------------------------------------ \\
    // -------------------------------------------------------------------------------------------------------------- \\

        public static <R> TransactionResult<R> of( final R result ){
            return new TransactionResult<>( result );
        }

        public static TransactionResult<Void> empty(){
            return new TransactionResult<>( null );
        }



    // -------------------------------------------------------------------------------------------------------------- \\
    // ---| SETTERS & GETTERS |-------------------------------------------------------------------------------------- \\
    // -------------------------------------------------------------------------------------------------------------- \\

        public void setException( final Exception exception ){
            this.exception = exception;
        }

        public T result(){
            return this.result;
        }



    // -------------------------------------------------------------------------------------------------------------- \\
    // ---| EXCEPTIONS |--------------------------------------------------------------------------------------------- \\
    // -------------------------------------------------------------------------------------------------------------- \\

        public TransactionResult<T> throwException() throws Exception {
            return this.throwException( Exception.class );
        }

        public TransactionResult<T> throwException( final Runnable runnable ) throws Exception {
            return this.throwException( Exception.class, runnable );
        }

        public <E extends Exception> TransactionResult<T> throwException( final Class<E> exception ) throws E {
            return this.throwException( exception, null );
        }

        public <E extends Exception> TransactionResult<T> throwException(
                final Class<E> exception,
                final Runnable runnable
        ) throws E {
            if( exception.isInstance( this.exception ) ){
                if( runnable != null ){
                    runnable.run();
                }

                throw exception.cast( this.exception );
            }
            return this;
        }

    // -------------------------------------------------------------------------------------------------------------- \\

    }

// ------------------------------------------------------------------------------------------------------------------ \\
}
