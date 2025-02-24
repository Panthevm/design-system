(ns design-system.combobox.element
  (:require [design-system.button.element     :as button]
            [design-system.input.element      :as input]
            [design-system.list-items.element :as list-items]))

(defn target
  [attrs]
  (button/secondary
   (merge
    {:class      "ds-combobox-target ds-text-value"
     :slot/right design-system.icons/chevron-down}
    (:attrs/ds-combobox-target attrs))
   (:slot/selected-value attrs)))

(defn options [attrs]
  (let [options            (:dropdown-options attrs)
        loading?           (:dropdown-loading? attrs)
        slot-empty-options (:slot/empty-options attrs)]
    (list-items/view
     (merge {:class "ds-combobox-list-items"} (:attrs/ds-combobox-list-items attrs))
     (cond
       (seq options)
       (for [option options]
         (list-items/item (merge (:attrs/ds-combobox-list-item attrs)
                                 (:attrs option))
                          (:slot/content option)))
       loading?
       (repeat 15 (list-items/item {:class "ds-preload"}))
       :else
       [:span.ds-combobox-empty-options slot-empty-options]))))

(defn dropdown [attrs]
  [:div.ds-combobox-dropdown (:attrs/ds-combobox-dropdown attrs)
   (input/search (merge {:class "ds-combobox-search"} (:attrs/ds-combobox-search attrs)))
   (options attrs)])

(defn view [attrs]
  [:div.ds-combobox
   (target attrs)
   (when (:dropdown-open? attrs)
     (dropdown attrs))])


(comment
  (design-system.core/doc #'view)
  (user/update-element-docs #'view))
