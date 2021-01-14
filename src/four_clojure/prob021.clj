(ns four-clojure.prob021)

;; #21 Nth Element

;; Difficulty:	Easy
;; Topics:	seqs core-functions


;; Write a function which returns the Nth element from a sequence.

(def ans0
  (fn [coll n]
    (loop [coll coll x 0]
      (if (= x n)
        (first coll)
        (recur (rest coll) (inc x))))))

(def ans2
  (fn [coll n]
    (first (drop n coll))))

(def ans
  #(first (drop %2 %1)))

(= true
   (= (ans '(4 5 6 7) 2) 6)
   (= (ans [:a :b :c] 0) :a)
   (= (ans [1 2 3 4] 1) 2)
   (= (ans '([1 2] [3 4] [5 6]) 2) [5 6]))
