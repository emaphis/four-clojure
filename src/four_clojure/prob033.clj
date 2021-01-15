(ns four-clojure.prob033)

;; #33 Replicate a Sequence

;; Difficulty:	Easy
;; Topics:	seqs

;; Write a function which replicates each element of a sequence a variable
;; number of times.

(def ans0
  (fn [coll n]
    (apply interleave (repeat n coll))))

(def ans
  (fn [coll n] (mapcat #(repeat n %) coll)))

;;(ans [1 2 3] 2)


(= true
   (= (ans [1 2 3] 2) '(1 1 2 2 3 3))
   (= (ans [:a :b] 4) '(:a :a :a :a :b :b :b :b))
   (= (ans [4 5 6] 1) '(4 5 6))
   (= (ans [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
   (= (ans [44 33] 2) [44 44 33 33]))
