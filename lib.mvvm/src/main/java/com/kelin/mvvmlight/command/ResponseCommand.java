package com.kelin.mvvmlight.command;


import io.reactivex.functions.Function;

/**
 * Created by kelin on 15-8-4.
 */
public class ResponseCommand<T, R> {

    private Function<T, R> execute;

    private boolean canExecute0 = true;

    /**
     * like {@link ReplyCommand},but ResponseCommand can return result when command has executed!
     * @param execute function to execute when event occur.
     */

    public ResponseCommand(Function<T, R> execute) {
        this.execute = execute;
    }

    public ResponseCommand(Function<T, R> execute, boolean canExecute0) {
        this.execute = execute;
        this.canExecute0 = canExecute0;
    }


    private boolean canExecute0() {
        return canExecute0;
    }


    public R execute(T parameter) {
        if (execute != null && canExecute0()) {
            try {
                return execute.apply(parameter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
