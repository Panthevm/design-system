(ns design-system.button.element
  (:require [design-system.utils :as utils]))

(defn view [params]
  (let [attrs-button   (:attrs/button params)
        content-button (:content/button params)
        attrs-right    (:attrs/right params)
        content-right  (:content/right params)]
    [:button.ds-button
     (cond-> attrs-button
       (:data/hovered? params)  (assoc :data-hovered "true")
       (:data/disabled? params) (assoc :disabled "true"))
     (when content-button
       [:span.ds-button-content content-button])
     (when (or attrs-right content-right)
       [:span.ds-button-right attrs-right content-right])]))

(defn secondary [params]
  (-> params
      (update-in [:attrs/button :class] #(utils/merge-classes "ds-button-secondary ds-text-button" %))
      (view)))

(comment
  (design-system.core/doc #'view)
  (user/update-element-docs #'view))
