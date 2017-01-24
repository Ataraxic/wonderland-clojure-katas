(ns tiny-maze.solver)


(defn map-deep-indexed
  [f matrix indices]
  (map-indexed 
   (fn [idx row-or-val]
     (if (sequential? row-or-val) 
       (map-matrix f row-or-val (conj idx indices))
       (f row-or-val indices))) 
   matrix))

(map-deep-indexed #(print % %2) [1 2 [1 2 3]] [])

(defn init-point [])

(defn initial-matrix 
  [matrix]
  (map-deep init-point matrix))

(defn split-point? [point])

(defn dir-tried? [dir])

(defn move [xpos, ypos,])
  



(defn solve-maze [maze])


