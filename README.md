# four-clojure

Another go at 4Clojure.

<https://www.4clojure.com/>


Testing multiple expressions with simple bolean expressions.

The file can be run in Emacs/Cider with the C-x C-k combo.

'''clojure
(def ans 3)

(= true
   (= ans (+ 1 2))
   (= ans (- 7 4)))
;; => true

(def ans2 [3])

(= true
   (= ans2 (rest [2 3]))
   (= ans2 (first [2 3]))
;; => false
'''


## License

Copyright © 2021 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
