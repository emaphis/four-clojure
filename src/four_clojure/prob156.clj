(ns four-clojure.prob156)

;; #156 Map Defaults

;; Difficulty:	Elementary
;; Topics:	seqs


;; When retrieving values from a map, you can specify default values in case the
;; key is not found:

(= 2 (:foo {:bar 0, :baz 1} 2))

;; However, what if you want the map itself to contain the default values?
;; Write a function which takes a default value and a sequence of keys and
;; constructs a map.

#_(def ans (fn [d coll] (apply hash-map (interleave coll (repeat d)))))

(def ans (fn [d coll] (zipmap coll (repeat d))))

;;(ans 0 [:a :b :c]) ; => {:c 0, :b 0, :a 0}

(= true
   (= (ans 0 [:a :b :c]) {:a 0 :b 0 :c 0})

   (= (ans "x" [1 2 3]) {1 "x" 2 "x" 3 "x"})

   (= (ans [:a :b] [:foo :bar]) {:foo [:a :b] :bar [:a :b]}))
