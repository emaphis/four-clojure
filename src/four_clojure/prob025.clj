(ns four-clojure.prob025)

;; #25 Find the odd numbers

;; Difficulty:	Easy
;; Topics:	seqs

;; Write a function which returns only the odd numbers from a sequence.

(def ans0
  (fn [coll]
    (loop [acc '() coll coll]
      (if (empty? coll)
        (reverse acc)
        (if (odd? (first coll))
          (recur (conj acc (first coll))
                 (rest coll))
          (recur acc (rest coll)))))))

(def ansfg
  (fn [coll]
    (filter odd? coll)))

;; #(filter odd? %)

(= true
   (= (ans #{1 2 3 4 5}) '(1 3 5))
   (= (ans [4 2 1 6]) '(1))
   (= (ans [2 2 4 6]) '())
   (= (ans [1 1 1 3]) '(1 1 1 3)))
