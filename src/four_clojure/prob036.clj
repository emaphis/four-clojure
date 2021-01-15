(ns four-clojure.prob036)

;; #36 Let it Be

;; Difficulty:	Elementary
;; Topics:	math syntax

;; Can you bind x, y, and z so that these are all true?

(= true
   (= 10 (let [x 7, y 3, z 1] (+ x y)))
   (= 4 (let [x 7, y 3, z 1] (+ y z)))
   (= 1 (let [x 7, y 3, z 1] z)))
