(ns four-clojure.prob134)

;; #134 A `nil` key

;; Difficulty:	Elementary
;; Topics:	maps

;; Write a function which, given a key and map, returns true iff the map
;; contains an entry with that key and its value is nil.

;; NOTE: If you need to distinguish between nil and non existent use `contains?`


(def ans (fn [ky mp] (and (contains? mp ky) (nil? (ky mp)))))

(= true
   (true?  (ans :a {:a nil :b 2}))

   (false? (ans :b {:a nil :b 2}))

   (false? (ans :c {:a nil :b 2})))
