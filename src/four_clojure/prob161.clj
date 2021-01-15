(ns four-clojure.prob161)

;; #161 Subset and Superset

;; Difficulty:	Elementary
;; Topics:	set-theory


;; Set A is a subset of set B, or equivalently B is a superset of A, if A is "contained"
;; inside B. A and B may coincide.


(def ans #{1 2})

(= true
   (clojure.set/superset? ans #{2})
   (clojure.set/subset? #{1} ans)
   (clojure.set/superset? ans #{1 2})
   (clojure.set/subset? #{1 2} ans))
