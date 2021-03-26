package org.ncq.commons.base;

/**
 * @author niuchangqing
 * 计时器
 */
public abstract class Ticker {

    /**
     * 纳秒Ticker
     */
    private static final Ticker NANO_TICKER = new Ticker() {
        @Override
        protected long read() {
            return System.nanoTime();
        }
    };

    /**
     * 读取当前时间
     */
    protected abstract long read();

    public static Ticker nanoTicker() {
        return NANO_TICKER;
    }
}
