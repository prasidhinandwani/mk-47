class Median {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length > b.length) {
            return findMedianSortedArrays(b, a);
        }

        int m = a.length, n = b.length;
        int l = 0, r = m;

        while (l <= r) {
            int x = (l + r) / 2;
            int y = (m + n + 1) / 2 - x;

            int al = (x == 0) ? Integer.MIN_VALUE : a[x - 1];
            int ar = (x == m) ? Integer.MAX_VALUE : a[x];

            int bl = (y == 0) ? Integer.MIN_VALUE : b[y - 1];
            int br = (y == n) ? Integer.MAX_VALUE : b[y];

            if (al <= br && bl <= ar) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(al, bl) + Math.min(ar, br)) / 2.0;
                }
                return Math.max(al, bl);
            } else if (al > br) {
                r = x - 1;
            } else {
                l = x + 1;
            }
        }

        return 0;
    }
}