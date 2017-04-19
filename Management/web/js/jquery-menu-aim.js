(function (a) {
    a.fn.menuAim = function (c) {
        this.each(function () {
            b.call(this, c)
        });
        return this
    };
    function b(c) {
        var d = a(this), q = null, g = [], r = null, p = null, s = a.extend({
            rowSelector: "> li",
            submenuSelector: "*",
            submenuDirection: "right",
            tolerance: 75,
            enter: a.noop,
            exit: a.noop,
            activate: a.noop,
            deactivate: a.noop,
            exitMenu: a.noop,
            exitActRow: a.noop
        }, c);
        var j = 3, f = 300;
        var e = function (t) {
            g.push({x: t.pageX, y: t.pageY});
            if (g.length > j) {
                g.shift()
            }
        };
        var o = function () {
            if (p) {
                clearTimeout(p)
            }
            if (s.exitActRow(this)) {
                q = null
            }
            if (s.exitMenu(this)) {
                if (q) {
                    s.deactivate(q)
                }
                q = null
            }
        };
        var l = function () {
            if (p) {
                clearTimeout(p)
            }
            s.enter(this);
            h(this)
        }, k = function () {
            s.exit(this)
        };
        var m = function () {
            i(this)
        };
        var i = function (t) {
            if (t == q) {
                return
            }
            if (q) {
                s.deactivate(q)
            }
            s.activate(t);
            q = t
        };
        var h = function (u) {
            var t = n();
            if (t) {
                p = setTimeout(function () {
                    h(u)
                }, t)
            } else {
                i(u)
            }
        };
        var n = function () {
            if (!q || !a(q).is(s.submenuSelector)) {
                return 0
            }
            var x = d.offset(), t = {x: x.left, y: x.top - s.tolerance}, E = {x: x.left + d.outerWidth(), y: t.y},
                G = {x: x.left, y: x.top + d.outerHeight() + s.tolerance}, y = {x: x.left + d.outerWidth(), y: G.y},
                z = g[g.length - 1], D = g[0];
            if (!z) {
                return 0
            }
            if (!D) {
                D = z
            }
            if (D.x < x.left || D.x > y.x || D.y < x.top || D.y > y.y) {
                return 0
            }
            if (r && z.x == r.x && z.y == r.y) {
                return 0
            }
            function A(I, H) {
                return (H.y - I.y) / (H.x - I.x)
            }

            var C = E, u = y;
            if (s.submenuDirection == "left") {
                C = G;
                u = t
            } else {
                if (s.submenuDirection == "below") {
                    C = y;
                    u = G
                } else {
                    if (s.submenuDirection == "above") {
                        C = t;
                        u = E
                    }
                }
            }
            var v = A(z, C), B = A(z, u), F = A(D, C), w = A(D, u);
            if (v < F && B > w) {
                r = z;
                return f
            }
            r = null;
            return 0
        };
        d.mouseleave(o).find(s.rowSelector).mouseenter(l).mouseleave(k).click(m);
        a(document).mousemove(e)
    }
})(jQuery);