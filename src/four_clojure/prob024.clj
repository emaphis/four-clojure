(ns four-clojure.prob024)

;; #2 4Sum It All Up

;; Difficulty:	Easy
;; Topics:	seqs

;; Write a function which returns the sum of a sequence of numbers.

(def ans0
  (fn [coll]
    (loop [acc 0 coll coll]
      (if (empty? coll)
        acc
        (recur (+ (first coll) acc) (rest coll))))))

;;(ans '(1 2 3))

(def ans
  #(reduce + 0 %))

(= true
   (= (ans [1 2 3]) 6)
   (= (ans (list 0 -2 5 5)) 8)
   (= (ans #{4 2 1}) 7)
   (= (ans '(0 0 -1)) -1)
   (= (ans '(1 10 3)) 14))
