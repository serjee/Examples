package info.signaltrade.testws;

import info.signaltrade.ws.statws.StatWsService;

import javax.xml.ws.Holder;

public class Main {

    public static void main(String[] args)
    {
        double balance  = 100.0;    // начальный баланс
        double payoff   = 0.83;     // выплата
        double amount   = 1;        // сумма сделки
        int limit       = 100;      // лимит расчета
        int v           = 60;       // вероятность

        for (int j=2; j<=10; j++) {
            getStatic(balance, payoff, j, amount, limit, v);
        }
    }

    /**
     *
     * @param balance - начальный баланс
     * @param payoff - выплата
     * @param s - лесенка
     * @param amount - начальная сумма сделки
     * @param limit - лимит расчета
     * @param v - вероятность
     *
     * @return
     */
    private static void getStatic(double balance, double payoff, int s, double amount, int limit, int v) {
        // кол.сделок
        int cnt = 0;
        int scn = 0;
        for (int i=1; i<=limit; i++) {
            cnt++;
            // имитируем результат
            if (rnd(0,100)<=v) {
                if (cnt<=s) {
                    balance = balance + (amount * payoff);
                    amount = amount + (amount * payoff); // для следующей
                } else {
                    balance = balance + (amount * payoff);
                    cnt=0;
                    amount = 1;
                    scn++;
                }
            } else {
                balance = balance - amount;
                cnt=0;
                amount = 1;
            }
        }

        System.out.println("balance["+s+"]="+round(balance, 2)+"; cnt="+scn);
    }

    private static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    private static void testWs()
    {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");

        final Holder<Integer> status = new Holder<Integer>();
        final Holder<String> msg = new Holder<String>();

        StatWsService sws = new StatWsService();
        //sws.getStatWsSOAP().average(1,2);
        sws.getStatWsSOAP().addStrategyStat(
                "testPaEma",
                "PaEma",
                "FOREX",
                "AUDUSD",
                1,
                3,
                "2017.01.01",
                "2017.07.31",
                885,
                417,
                468,
                Double.parseDouble(String.valueOf(47.12)),
                Double.parseDouble(String.valueOf(52.88)),
                Double.parseDouble(String.valueOf(-0.12)),
                Double.parseDouble(String.valueOf(0.82)),
                Double.parseDouble(String.valueOf(1.30)),
                2,
                2,
                0,
                0,
                "",
                "",
                Double.parseDouble(String.valueOf(99)),
                status,
                msg
        );

        System.out.println("status="+status.value+", message="+msg.value);
    }
}
