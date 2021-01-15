(ns four-clojure.prob023)b

;; #23 Reverse a Sequence

;; Difficulty:	Easy
;; Topics:	seqs core-functions

;; Write a function which reverses a sequence.

(def ans1
  (fn [coll]
    (loop [coll coll acc '()]
      (if (empty? coll)
        acc
        (recur (rest coll) (conj acc (first coll)))))))

(def ans2
  (fn [coll]
    (reduce conj () coll)))

(def ans
  #(reduce conj () %))

;;(ans [1 2 3])


(= true
   (= (ans [1 2 3 4 5]) [5 4 3 2 1])
   (= (ans (sorted-set 5 7 2 7)) '(7 5 2))
   (= (ans [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]]))
