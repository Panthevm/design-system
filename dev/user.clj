(ns user
  (:require [clojure.string]
            [hiccup.core]))

(defn update-element-docs [element-ref]
  (let [element-meta     (meta element-ref)
        element-ns       (:ns element-meta)
        element-file     (:file element-meta)
        element-doc-file (-> (clojure.string/split element-file #"/")
                             (pop)
                             (conj "docs.edn")
                             (->> (clojure.string/join "/")))]
    (spit (str "resources/" element-ns ".html")
          (-> element-doc-file slurp read-string eval hiccup.core/html))))
