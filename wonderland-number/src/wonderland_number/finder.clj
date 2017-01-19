(ns wonderland-number.finder)

(def known-numbers '(2 3 4 5 6))

(defn convert-to-seq [number]
  (map read-string (re-seq #"\d" (str number))))


(defn check-number
  [& args]
  (if (apply = (map sort (map convert-to-seq args)))
    true
    false
    ))

(first (filter #(not (nil? %)) (list (check-number 12345 54321))))

(defn valid-number [n] 
  (first 
   (filter (fn [l] (every? #(true? %) l))
           (map 
            (fn [multiplied] (check-number n multiplied)) 
            (map 
             (fn [arg] (* n arg)) known-numbers)))))



(defn valid-number 
  [n]
  (if (every? #(true? %) 
              (map
               (fn [m] (check-number n m))
               (map (fn [arg] (* n arg)) known-numbers)))
   n
   ))
(defn wonderland-number [] (filter #(not (nil? %)) (map valid-number (range 100000 1000000))))

(wonderland-number)
