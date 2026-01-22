package com.example.Ttask2;

public class HardOne {
    public static int goodSubString(String s) {
        int n = s.length();

        String tbank = "tbank";
        String study = "study";
        // Длина каждой подстроки
        int len = 5;

        // Предподсчет стоимостей для каждой позиции
        int[] costTbank = new int[n];
        int[] costStudy = new int[n];

        for (int i = 0; i <= n - len; i++) {
            int cntTbank = 0;
            int cntStudy = 0;
            for (int k = 0; k < len; k++) {
                if (s.charAt(i + k) != tbank.charAt(k)) cntTbank++;
                if (s.charAt(i + k) != study.charAt(k)) cntStudy++;
            }
            costTbank[i] = cntTbank;
            costStudy[i] = cntStudy;
        }

        // Минимальная стоимость для непересекающихся подстрок
        int INF = 1000000000;
        int res = INF;

        // Префиксные и суффиксные минимумы для costStudy
        int[] prefMinStudy = new int[n];
        int[] suffMinStudy = new int[n];
        for (int i = 0; i < n; i++) {
            prefMinStudy[i] = INF;
            suffMinStudy[i] = INF;
        }

        for (int i = 0; i <= n - len; i++) {
            prefMinStudy[i] = costStudy[i];
            if (i > 0) prefMinStudy[i] = Math.min(prefMinStudy[i], prefMinStudy[i - 1]);
        }

        for (int i = n - len; i >= 0; i--) {
            suffMinStudy[i] = costStudy[i];
            if (i < n - len) suffMinStudy[i] = Math.min(suffMinStudy[i], suffMinStudy[i + 1]);
        }

        // Случай непересекающихся подстрок
        for (int i = 0; i <= n - len; i++) {
            int left = INF;
            if (i - len >= 0) left = prefMinStudy[i - len];
            int right = INF;
            if (i + len <= n - len) right = suffMinStudy[i + len];
            int bestOther = Math.min(left, right);
            if (bestOther < INF) {
                res = Math.min(res, costTbank[i] + bestOther);
            }
        }

        // Случай пересекающихся подстрок (|d| < 5)
        for (int d = -4; d <= 4; d++) {
            if (d == 0) continue;

            // Проверка допустимости d
            boolean conflict = false;
            if (d > 0) {
                for (int t = 0; t < 5 - d; t++) {
                    if (tbank.charAt(d + t) != study.charAt(t)) {
                        conflict = true;
                        break;
                    }
                }
            } else { // d < 0
                for (int t = 0; t < 5 + d; t++) { // 5 - |d|
                    if (tbank.charAt(t) != study.charAt(t - d)) {
                        conflict = true;
                        break;
                    }
                }
            }
            if (conflict) continue;

            // Построение шаблона T_d
            int overlapLen = 5 + Math.abs(d);
            char[] pattern = new char[overlapLen];
            if (d > 0) {
                for (int t = 0; t < overlapLen; t++) {
                    if (t < d) {
                        pattern[t] = tbank.charAt(t);
                    } else {
                        if (t <= 4) {
                            pattern[t] = tbank.charAt(t);
                        } else {
                            pattern[t] = study.charAt(t - d);
                        }
                    }
                }
            } else { // d < 0
                for (int t = 0; t < overlapLen; t++) {
                    if (t < -d) {
                        pattern[t] = study.charAt(t);
                    } else {
                        if (t <= 4) {
                            pattern[t] = study.charAt(t);
                        } else {
                            pattern[t] = tbank.charAt(t + d);
                        }
                    }
                }
            }

            // Перебор начал общей области
            if (d > 0) {
                int maxL = Math.min(n - len, n - len - d);
                maxL = Math.min(maxL, n - overlapLen);
                for (int L = 0; L <= maxL; L++) {
                    int cost = 0;
                    for (int k = 0; k < overlapLen; k++) {
                        if (s.charAt(L + k) != pattern[k]) cost++;
                    }
                    res = Math.min(res, cost);
                }
            } else { // d < 0
                int maxL = Math.min(n - len, n - len + d);
                maxL = Math.min(maxL, n - overlapLen);
                for (int L = -d; L <= maxL; L++) {
                    int cost = 0;
                    for (int k = 0; k < overlapLen; k++) {
                        if (s.charAt(L + k) != pattern[k]) cost++;
                    }
                    res = Math.min(res, cost);
                }
            }
        }
        return res;
    }
}