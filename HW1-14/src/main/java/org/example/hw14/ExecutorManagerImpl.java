package org.example.hw14;

public class ExecutorManagerImpl implements ExecutionManager, Context{
    @Override
    public Context execute(Runnable callback, Runnable... tasks) {
        return null;
    }

    @Override
    public int getCompletedTaskCount() {
        return 0;
    }

    @Override
    public int getFailedTaskCount() {
        return 0;
    }

    @Override
    public int getInterruptedTaskCount() {
        return 0;
    }

    @Override
    public void interrupt() {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
