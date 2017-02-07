(ns tiny-maze.solver)
(defn map-deep
  [f matrix]
  (map
   (fn [row-or-val]
     (if (sequential? row-or-val) 
       (map-matrix f row-or-val)
       (f row-or-val))) 
   matrix))

(defn map-deep-indexed
  [f matrix indices]
  (map-indexed
   (fn [idx item]
     (print indices item)
     (if (sequential? item)
       (map-deep-indexed f item (conj indices idx))
       (f (conj indices idx) item)))
   matrix))

(defn find-start-point
  [matrix]
  (first
   (filter 
    identity
    (mapcat 
     identity
     (map-deep-indexed 
      (fn [index point] (get {true index false nil} (= point :S)))
      matrix
      [])))))

(def sample-maze [[:S 0 1][1  0 1][1  0 :E]])

(defn get-val [indices matrix]
  (nth (nth matrix (first indices)) (second indices)))

(defn gen-tree [starting-point matrix]
  (loop []))

(filter
 identity
 (map
  (fn [set] 
    (if (= "s" (:val set))
        (:indices set)
        'nil))
  (flatten 
   (map-deep-indexed 
    #(identity {:indices %1 :val %2 }) [[1 2 3 4] ["s" 1 2]] []))))

(defn bfs [tree]
  (loop []))

(defn cull-bounds [positions max]
  (filter identity (map #(if (or (> % max) (< % 0)) 'nil %) positions)))

(defn combine [x-poss y-poss]
   (mapcat
     (fn [x] (map (fn [y] (vec (list x y))) y-poss))
     x-poss))

(defn moves [prev-position start-index matrix]
  (let [x-length (count matrix) y-length (count (nth matrix 0))] 
       (filter
        #(not (= % prev-position))
        (combine
         (cull-bounds [(+ x-length 1) (- x-length 1)] x-length)
         (cull-bounds [(+ y-length 1) (- y-length 1)] y-length)))))
         
(get-val (moves [0 0] [0 0] sample-maze) sample-maze)

(defn move [prev-pos curr-pos matrix]
  (let [pos-moves (moves prev-pos curr-pos matrix)]
    (if (= :E (get-val matrix curr-pos))
      (curr-pos)
      (if (> 1 (count pos-moves))
          (map) 
          (move [curr-pos (first pos-moves) matrix])))))


(possible-moves [0 0] [[:S 0 1] [1  0 1] [1  0 :E]])


(defn possible-moves 
  [current-indice matrix]
  ())
  


(defn init-point [])

(defn initial-matrix 
  [matrix]
  (map-deep init-point matrix))

(defn split-point? [point])

(defn dir-tried? [dir])

(defn move [xpos, ypos,])

 




(defn solve-maze [maze])


