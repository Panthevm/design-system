(ns design-system.utils)

(defn get-element-attributes
  [arguments]
  (let [properties (first arguments)]
    (when (map? properties)
      properties)))

(defn get-element-content
  [arguments]
  (if (get-element-attributes arguments)
    (seq (next arguments))
    arguments))

(defn merge-classes
  [class-a class-b]
  (cond
    (nil? class-a)
    class-b

    (nil? class-b)
    class-a

    (and (string? class-a)
         (string? class-b))
    [class-a class-b]

    (and (string? class-a)
         (sequential? class-b))
    (cons class-a class-b)

    (and (sequential? class-a)
         (string? class-b))
    (concat class-a [class-b])

    (and (sequential? class-a)
         (sequential? class-b))
    (concat class-a class-b)))
